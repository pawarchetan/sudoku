package com.example.sudoku.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class BoardValidationService {

    public boolean isValidSudoku(int[][] board) {
        int N = board.length;

        // Use hash set to record the status
        HashSet<Integer>[] rows = new HashSet[N];
        HashSet<Integer>[] cols = new HashSet[N];
        HashSet<Integer>[] boxes = new HashSet[N];
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int val = board[r][c];

                // Check if the position is filled with number
                if (val == 0) {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }

}
