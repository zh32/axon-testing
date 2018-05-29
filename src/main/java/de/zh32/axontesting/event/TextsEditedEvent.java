package de.zh32.axontesting.event;

import lombok.Data;

@Data
public class TextsEditedEvent {
	private final String name;
	private final String description;
}
