package com.example.esunbackend.esun;

import org.springframework.data.domain.AbstractAggregateRoot;

public abstract class BaseAggregate<A> extends AbstractAggregateRoot<BaseAggregate<A>> {

	/**
	 * Method to register the event
	 * 
	 * @param event
	 */
	protected void addDomainEvent(Object event) {
		registerEvent(event);
	}
	
}
