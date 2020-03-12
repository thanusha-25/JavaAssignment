package module3;
import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
public class EarthquakeCityMap extends PApplet {
	private static final long serialVersionUID = 1L;
	private static final boolean offline = false;
	public static final float THRESHOLD_MODERATE = 5;
	public static final float THRESHOLD_LIGHT = 4;
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	private UnfoldingMap map;
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";
	public void setup() {
		size(950, 600, OPENGL);
		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
	    List<Marker> markers = new ArrayList<Marker>();
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
             quakeMarkers = new ArrayList<Marker>(); 
	    for(PointFeature feature : earthquakes) {
		  if(isLand(feature)) {
		    quakeMarkers.add(new LandQuakeMarker(feature));
		  }
		  else {
		    quakeMarkers.add(new OceanQuakeMarker(feature));
		  }
	    }
    printQuakes();
	    map.addMarkers(quakeMarkers);	   
	  map.addMarkers(markers);
	}
		
	private SimplePointMarker createMarker(PointFeature feature)
	{  
		SimplePointMarker marker = new SimplePointMarker(feature.getLocation());
		
		Object magObj = feature.getProperty("magnitude");
		float mag = Float.parseFloat(magObj.toString());
		 int yellow = color(255, 255, 0);
	    return marker;
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}
	private void addKey() 
	{	
		fill(255, 250, 240);
		rect(25, 50, 150, 250);
		
		fill(0);
		textAlign(LEFT, CENTER);
		textSize(12);
		text("Earthquake Key", 50, 75);
		
		fill(color(255, 0, 0));
		ellipse(50, 125, 15, 15);
		fill(color(255, 255, 0));
		ellipse(50, 175, 10, 10);
		fill(color(0, 0, 255));
		ellipse(50, 225, 5, 5);
		
		fill(0, 0, 0);
		text("5.0+ Magnitude", 75, 125);
		text("4.0+ Magnitude", 75, 175);
		text("Below 4.0", 75, 225);
	}
}
