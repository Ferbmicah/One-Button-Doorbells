package io.github.Ferbmicah.onebuttondoorbells;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneButtonDoorbells implements ModInitializer {
	public static final String ID = "one_button_doorbells";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[One Button Doorbells] pretty pink princess ponies prancing perpendicular");
	}
}
