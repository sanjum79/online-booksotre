import { Book } from './../../common/book';
import { BookService } from './../../services/book.service';
import { BOOKS } from './../../mock-books';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  // books = BOOKS;
  books: Book[];
  constructor(private _bookService: BookService) { }

  ngOnInit() {
    this.listBooks();
  }

  listBooks() {
    this._bookService.getBooks().subscribe(
      listOfBooks => this.books = listOfBooks
    )
    
  }

}
