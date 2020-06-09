import { Book } from './../../common/book';
import { BookService } from './../../services/book.service';
import { BOOKS } from './../../mock-books';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-list',
  // templateUrl: './book-list.component.html',
  templateUrl: './book-grid.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  // books = BOOKS;
  books: Book[] = [];
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;
  constructor(private _bookService: BookService,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this._activatedRoute.paramMap.subscribe(()=> {
      this.listBooks();
    })
  }

  listBooks() {
    const hasCategoryId: boolean = this._activatedRoute.snapshot.paramMap.has('id');

    if(hasCategoryId){
      this.currentCategoryId  = +this._activatedRoute.snapshot.paramMap.get("id");
    } else {
      this.currentCategoryId = 1;
    }
    
    this._bookService.getBooks(this.currentCategoryId).subscribe(
      listOfBooks => this.books = listOfBooks
    )
  }

}
