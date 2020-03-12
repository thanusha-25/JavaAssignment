package module1;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
public class HelloWorld extends PApplet
{
private static final long serialVersionUID = 1L;
public static String mbTilesString = "blankLight-1-3.mbtiles";
	private static final boolean offline = false;
	UnfoldingMap map1;
	UnfoldingMap map2;

	public void setup() {
		size(800, 600, P2D); 
		this.background(200, 200, 200);
		AbstractMapProvider provider = new Google.GoogleTerrainProvider();
		int zoomLevel = 10;
		if (offline) {
			provider = new MBTilesMapProvider(mbTilesString);
			zoomLevel = 3;
		}
			map1 = new UnfoldingMap(this, 50, 50, 350, 500, provider);
	  map1.zoomAndPanTo(zoomLevel, new Location(32.9f, -117.2f));
		MapUtils.createDefaultEventDispatcher(this, map1);
	}
	public void draw() {
		map1.draw();
	}

	
}
