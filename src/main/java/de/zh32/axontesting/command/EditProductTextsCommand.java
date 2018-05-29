package de.zh32.axontesting.command;

import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data
public class EditProductTextsCommand {
	@TargetAggregateIdentifier
	private final String partNumber;
	private final String name;
	private final String description;
}
