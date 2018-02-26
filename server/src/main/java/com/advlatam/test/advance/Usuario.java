package com.advlatam.test.advance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;
	private @NonNull String cedula;
	private @NonNull String nombres;
	private @NonNull String apellidos;
	private String correo;
	private @NonNull String telefono;
	
}
