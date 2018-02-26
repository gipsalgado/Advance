import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { UsuarioService } from './shared/usuario/usuario.service';
import { UsuarioListComponent } from './usuario-list/usuario-list.component';
import { UsuarioEditComponent } from './usuario-edit/usuario-edit.component';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule, MatPaginatorModule, MatNativeDateModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: '', redirectTo: '/usuario-list', pathMatch: 'full' },
  {
    path: 'usuario-list',
    component: UsuarioListComponent
  },
  {
    path: 'usuario-add',
    component: UsuarioEditComponent
  },
  {
    path: 'usuario-edit/:id',
    component: UsuarioEditComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
	UsuarioListComponent,
	UsuarioEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
	MatTableModule,
	MatPaginatorModule,
	MatDatepickerModule,
	MatNativeDateModule,
	FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }