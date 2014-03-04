package br.com.nerdsolutions.transferencia.infraestrutura.converter;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

/**
 * Conversor personalizado de {@link String} para {@link Calendar} utilizado
 * pelo VRaptor.
 * 
 * @author Newton Angelini
 * 
 */
@Convert(Calendar.class)
@ApplicationScoped
public class CalendarConverter implements Converter<Calendar> {

	/**
	 * Formato de data utilizado no sistema.
	 */
	private static final String FORMATO = "yyyy-MM-dd";

	public Calendar convert(String value, Class<? extends Calendar> type,
			ResourceBundle bundle) {
		if (value == null || value.isEmpty())
			return null;

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(FORMATO).parse(value));
			return calendar;
		} catch (ParseException e) {
			throw new ConversionError(MessageFormat.format(
					bundle.getString("conversor.data.invalida"), value));
		}
	}

}
