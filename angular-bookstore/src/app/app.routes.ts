import { BookDetailsComponent } from './components/book-details/book-details.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { Routes } from '@angular/router';

export const ROUTES: Routes = [
        { path: 'books/:id', component: BookDetailsComponent },
        { path: 'books', component: BookListComponent },
        { path: 'search/:keyword', component: BookListComponent },
        { path: 'category/:id', component: BookListComponent },
        { path: '', redirectTo: '/books', pathMatch: 'full' },
        { path: '**', component: PageNotFoundComponent }
       ];
