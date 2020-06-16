import { Book } from './../../common/book';
import { BookService } from './../../services/book.service';
import { Component, OnInit } from '@angular/core';
import { ActivationEnd, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  book: Book = new Book();

  constructor(private _activatedRoue: ActivatedRoute,
              private _bookService: BookService) { }

  ngOnInit() {
    this._activatedRoue.paramMap.subscribe(
      ()=> {
        this.getBookInfo();
      }
    )
  }

  getBookInfo(){
    const id: number = +this._activatedRoue.snapshot.paramMap.get('id');
    this._bookService.get(id).subscribe(
      data =>{
        this.book = data;
      }
    )
  } 

}
