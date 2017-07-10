package tpIS;

import java.util.List;

public class CatalogoDeRigs {
	private List<ModeloRig> ModelosRigs;

	public CatalogoDeRigs(List<ModeloRig> modelosRigs) {
		ModelosRigs=modelosRigs;
	}

	public List<ModeloRig> getModelosRigs() {
		return ModelosRigs;
	}
	
	public void agregarModelo(ModeloRig nuevo) {
		ModelosRigs.add(nuevo);
	}
	
}
