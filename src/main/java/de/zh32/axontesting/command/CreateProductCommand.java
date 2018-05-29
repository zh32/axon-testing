package de.zh32.axontesting.command;

import lombok.Data;

@Data
public class CreateProductCommand {
	private final String partNumber;
}
