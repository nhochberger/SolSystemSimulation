package model;

import java.util.LinkedList;
import java.util.List;

import hochberger.utilities.text.i18n.DirectI18N;
import hochberger.utilities.text.i18n.I18N;

public class CelestialBody {

	private final String name;
	private final double radius;
	private final double semiMajorAxis;
	private final double eccentricity;
	private final double longitudeOfAscendingNode;
	private final double inclination;
	private final double argumentOfPeriapsis;
	private double trueAnomaly;
	private final double rotationPeriod;
	private final List<CelestialBody> children;
	private final double meanAnomaly;

	public CelestialBody(final String name, final double radius, final double semiMajorAxis, final double eccentricity, final double longitudeOfAscendingNode, final double inclination,
			final double argumentOfPeriapsis, final double meanAnomaly, final double rotationPeriod) {
		super();
		this.name = name;
		this.radius = radius;
		this.semiMajorAxis = semiMajorAxis;
		this.eccentricity = eccentricity;
		this.longitudeOfAscendingNode = longitudeOfAscendingNode;
		this.inclination = inclination;
		this.argumentOfPeriapsis = argumentOfPeriapsis;
		this.meanAnomaly = meanAnomaly;
		this.rotationPeriod = rotationPeriod;
		this.children = new LinkedList<>();
	}

	public String getName() {
		return this.name;
	}

	public double getRadius() {
		return this.radius;
	}

	public double getSemiMajorAxis() {
		return this.semiMajorAxis;
	}

	public double getEccentricity() {
		return this.eccentricity;
	}

	public double getTrueAnomaly() {
		return this.trueAnomaly;
	}

	public void setTrueAnomaly(final double trueAnomaly) {
		this.trueAnomaly = trueAnomaly;
	}

	public double getLongitudeOfAscendingNode() {
		return this.longitudeOfAscendingNode;
	}

	public double getInclination() {
		return this.inclination;
	}

	public double getArgumentOfPeriapsis() {
		return this.argumentOfPeriapsis;
	}

	public double getLengthOfDay() {
		return this.rotationPeriod;
	}

	public List<CelestialBody> getChildren() {
		return this.children;
	}

	public void addChild(final CelestialBody child) {
		this.children.add(child);
	}

	public double getRotationPeriod() {
		return this.rotationPeriod;
	}

	public double getMeanAnomaly() {
		return this.meanAnomaly;
	}

	@Override
	public String toString() {
		I18N information = new DirectI18N(
				"{0} (semi major axis: {1} km, eccentricity: {2}, inclination: {3}°, argument of periapsis: {4}°, longitude of ascending node: {5}°, true anomaly: {6}, radius: {7} km", this.name,
				String.valueOf(this.semiMajorAxis), String.valueOf(this.eccentricity), String.valueOf(this.inclination), String.valueOf(this.argumentOfPeriapsis),
				String.valueOf(this.longitudeOfAscendingNode), String.valueOf(this.trueAnomaly));
		return information.toString();
	}
}
