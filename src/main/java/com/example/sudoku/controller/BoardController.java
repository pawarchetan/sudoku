package com.example.sudoku.controller;

import com.example.sudoku.service.BoardValidationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
@CrossOrigin(origins = "http://localhost:4200")
public class BoardController {

    private final BoardValidationService boardValidationService;

    public BoardController(BoardValidationService boardValidationService) {
        this.boardValidationService = boardValidationService;
    }

    @GetMapping
    public int[][] getBoard() {

        return new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    }

    @PostMapping
    public boolean validateBoard(@RequestBody int[][] board) {
        return boardValidationService.isValidSudoku(board);
    }
}
