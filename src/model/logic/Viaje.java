package model.logic;

public class Viaje
{
	private double sourceid;
	private double dstid;
	private double month;
	private double mean_travel_time;
	private double standard_deviation_travel_time;
	private double geometric_mean_travel_time;
	private double geometric_standard_deviation_travel_time;
	
	public Viaje(String _sourceid, String _dstid, String _month, String _mean_travel_time, String _standard_deviation_travel_time, String _geometric_mean_travel_time, String _geometric_standard_deviation_travel_time)
	{
		setSourceid(Double.parseDouble(_sourceid));
		setDstid(Double.parseDouble(_dstid));
		setMonth(Double.parseDouble(_month));
		setMean_travel_time(Double.parseDouble(_mean_travel_time));
		setStandard_deviation_travel_time(Double.parseDouble(_standard_deviation_travel_time));
		setGeometric_mean_travel_time(Double.parseDouble(_geometric_mean_travel_time));
		setGeometric_standard_deviation_travel_time(Double.parseDouble(_geometric_standard_deviation_travel_time));
	}

	public double getSourceid() {
		return sourceid;
	}

	public void setSourceid(double sourceid) {
		this.sourceid = sourceid;
	}

	public double getDstid() {
		return dstid;
	}

	public void setDstid(double dstid) {
		this.dstid = dstid;
	}

	public double getMonth() {
		return month;
	}

	public void setMonth(double month) {
		this.month = month;
	}

	public double getMean_travel_time() {
		return mean_travel_time;
	}

	public void setMean_travel_time(double mean_travel_time) {
		this.mean_travel_time = mean_travel_time;
	}

	public double getStandard_deviation_travel_time() {
		return standard_deviation_travel_time;
	}

	public void setStandard_deviation_travel_time(double standard_deviation_travel_time) {
		this.standard_deviation_travel_time = standard_deviation_travel_time;
	}

	public double getGeometric_mean_travel_time() {
		return geometric_mean_travel_time;
	}

	public void setGeometric_mean_travel_time(double geometric_mean_travel_time) {
		this.geometric_mean_travel_time = geometric_mean_travel_time;
	}

	public double getGeometric_standard_deviation_travel_time() {
		return geometric_standard_deviation_travel_time;
	}

	public void setGeometric_standard_deviation_travel_time(double geometric_standard_deviation_travel_time) {
		this.geometric_standard_deviation_travel_time = geometric_standard_deviation_travel_time;
	}

}
