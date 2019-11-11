
package acme.features.authenticated.consumer.offer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.offer.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/authenticated/consumer/offer/")
public class ConsumerOfferController extends AbstractController<Consumer, Offer> {

	@Autowired
	private ConsumerOfferCreateService createService;


	@Autowired

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}