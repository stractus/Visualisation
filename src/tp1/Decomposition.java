package tp1;

public class Decomposition {

	public static double[] decomposition(double[] data_in, String arg, int left){
		double[] data_out = new double[data_in.length];
		switch (arg){
			case "one":
				data_out = algo(data_in, 1, left, (float) 0.0);
				break;
			case "all":
				data_out = algo(data_in, 1, left, (float) 0.0);
				break;
			default:
				data_out = algo(data_in, 1, left, Float.parseFloat(arg));
				break;
		}
				
		return data_out;
	}
	
	public static double[] algo (double[] data_in, int rank, int left, float floor){
		int size_of_data = data_in.length;
		double[] data_out = new double[size_of_data];
		System.out.println("Alors size of data " + 
				data_in.length + " et rank vaut : " + rank);
		data_out = data_in.clone();
		// composition de la premiere partie des données
		for(int i=0; i < (int) (size_of_data/(Math.pow(2, rank))); i++){
			data_out[i] = (float) 0.5*(data_in[2*i] + data_in[2*i+1]);
		}
		System.out.println("les données sont de : 0" +
				" à " + (size_of_data/(Math.pow(2, rank))));
		// composition de la seconde partie des données
		int j = 0;
		for(int i = (int) (size_of_data/(Math.pow(2, rank))); i < 2*(size_of_data/(Math.pow(2, rank))); i++){
			data_out[i] = (float) 0.5*(data_in[2*j] - data_in[2*j+1]);	
			if (Math.abs(data_out[i]) < Math.abs(floor)){
				data_out[i] = 0;
			}
			j++;
		}
		System.out.println("les détails sont de : " + size_of_data/(Math.pow(2, rank)) +
				" à " + size_of_data/rank
				);
		if (left == 1){
			return data_out;
		} else {
			rank = rank + 1;
			left = left - 1;
			return (algo(data_out, rank, left, floor));
		}
	}
}
