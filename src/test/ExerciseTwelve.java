package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ExerciseTwelve {
	
	public void readJson() {
		 JSONParser jsonParser = new JSONParser();
		 try {
			FileReader file = new FileReader("files/VentasPorMes.json");
			Object obj = jsonParser.parse(file);
			JSONArray listVentas = (JSONArray) obj;
			List<VentasPorMes> ventas = new  ArrayList<VentasPorMes>();
			listVentas.forEach(v -> {
				VentasPorMes venta = new VentasPorMes((String) ((JSONObject) v).get("ciudad"), (String) ((JSONObject) v).get("almacen"), (String) ((JSONObject) v).get("mes"), (Long) ((JSONObject) v).get("venta"));
				ventas.add(venta);
			});
			Function<VentasPorMes, List<Object>> compositeKey = ventasRecord ->
		    Arrays.<Object>asList(ventasRecord.getCiudad(), ventasRecord.getMes());
		    
			ventas.stream()
			.collect(Collectors.groupingBy(compositeKey, Collectors.summingLong(VentasPorMes::getVenta)))
			.forEach((value,valor) -> System.out.println(value +" = "+ valor));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error al leer el archivo");
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("Error al leer el archivo");
		}
		 
	}
	
}
