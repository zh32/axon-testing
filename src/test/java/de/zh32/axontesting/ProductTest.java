package de.zh32.axontesting;

import de.zh32.axontesting.command.CreateProductCommand;
import de.zh32.axontesting.event.ProductCreatedEvent;
import org.axonframework.eventsourcing.eventstore.EventStoreException;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.any;

public class ProductTest {

	public static final String PART_NUMBER = "123";

	private FixtureConfiguration<Product> fixture;

	@Before
	public void setUp() {
		fixture = new AggregateTestFixture<>(Product.class);
	}

	@Test
	public void can_create_product() {
		fixture.givenNoPriorActivity()
				.when(new CreateProductCommand(PART_NUMBER))
				.expectSuccessfulHandlerExecution()
				.expectEvents(new ProductCreatedEvent(PART_NUMBER));
	}

	@Test
	public void cant_create_product_if_already_exists() {
		fixture.given(new ProductCreatedEvent(PART_NUMBER))
				.when(new CreateProductCommand(PART_NUMBER))
				.expectException(any(EventStoreException.class));
	}
}
