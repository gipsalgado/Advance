import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuarioService } from '../shared/usuario/usuario.service';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})

export class UsuarioListComponent implements OnInit {
	
  displayedColumns = ['cedula', 'apellidos', 'nombres', 'correo', 'editar'];
  dataSource: MatTableDataSource<UserData>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
	
  usuarios: Array<any>;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
	this.usuarioService.getAll().subscribe(data => {
      this.usuarios = data;
	  this.dataSource = new MatTableDataSource(this.usuarios);
	  this.dataSource.paginator = this.paginator;
	  this.dataSource.sort = this.sort;
    });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

}

export interface UserData {
  cedula: string;
  apellidos: string;
  nombres: string;
  correo: string;
}