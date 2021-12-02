package com.revature.icecream.app;

import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

public class Driver {
	static IceCream[] icecreams;
	static int currentIndex;
	
	public static void main(String[] args) {
		//currentIndex=0;
		//icecreams = new IceCream[10]; // Initializing icecream array
		List<IceCream> arrlst = new ArrayList<IceCream>();
		
		
		
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/icecream", ctx -> { // info will be coming in as form parameters
			IceCream icecream = new IceCream();
			
			icecream.flavor = ctx.formParam("flavor");
			icecream.toppings = ctx.formParam("toppings");
			icecream.basetype = ctx.formParam("basetype");
			icecream.numberofscoops = Integer.parseInt(ctx.formParam("numberofscoops") );
			// ^^ form params
			
			arrlst.add(icecream);
			currentIndex++;
			
			String responseText = "";
	
			
			for (IceCream eachIcecream : arrlst) {
				System.out.println(eachIcecream);
				if(eachIcecream != null) {
				responseText += eachIcecream.flavor + "<br>";												
				}
				if(eachIcecream != null) {
					responseText += eachIcecream.toppings + "<br>";
				}
				if(eachIcecream != null) {
					responseText += eachIcecream.basetype + "<br>";
				}
				if(eachIcecream != null) {
					responseText += eachIcecream.numberofscoops + "<br>";
					}
			}
			
			ctx.html(responseText);
		});
	}

}
