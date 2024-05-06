import {Component} from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'sudoku-angular';
  board: number[][];
  isValid: boolean = true;

  constructor(private http: HttpClient) {
    // Initialize the Sudoku board with empty cells
    this.board = [[]];

    this.http.get<number[][]>('http://localhost:8080/board').subscribe((response) => {
      this.board = response;

      this.http.post<boolean>('http://localhost:8080/board', this.board).subscribe((response) => {
        this.isValid = response;
      });
    });
  }

  handleInput(row: number, col: number, event: Event) {
    const value = (event.target as HTMLInputElement).value;
    this.board[row][col] = parseInt(value);

    this.http.post<boolean>('http://localhost:8080/board', this.board).subscribe((response) => {
      this.isValid = response;
    });
  }

  trackByIndex(index: number, item: any) {
    return index;
  }
}
