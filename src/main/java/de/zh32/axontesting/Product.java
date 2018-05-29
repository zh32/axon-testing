package de.zh32.axontesting;

import de.zh32.axontesting.command.CreateProductCommand;
import de.zh32.axontesting.command.EditProductTextsCommand;
import de.zh32.axontesting.event.ProductCreatedEvent;
import de.zh32.axontesting.event.TextsEditedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class Product {

	@AggregateIdentifier
	private String partNumber;

	private String name;
	private String description;

	@CommandHandler
	public Product(CreateProductCommand command) {
		this.partNumber = command.getPartNumber();
		apply(new ProductCreatedEvent(partNumber));
	}

	@CommandHandler
	public void handle(EditProductTextsCommand command) {
		this.name = command.getName();
		this.description = command.getDescription();
		apply(new TextsEditedEvent(command.getName(), command.getDescription()));
	}

}
