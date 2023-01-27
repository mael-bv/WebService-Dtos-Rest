package com.compteservice.dtos;

import lombok.Data;

@Data
public class VirementRequestDto {
	private Long idGive;
	private Long idTake;
	private double montant;

}
