package tpIS;

import java.util.List;

public class Catalogo {
	private List<ModeloRig> ModelosRigs;
	private List<ModeloTanque> ModelosDeTanques;
	private List<ModeloPlanta> ModelosPlantas;

	public Catalogo(List<ModeloRig> modelosRigs, List<ModeloTanque> modelosTanques, List<ModeloPlanta> ModelosDePlantas) {
		ModelosRigs=modelosRigs;
		ModelosDeTanques = modelosTanques;
		ModelosPlantas = ModelosDePlantas;
	}

	public List<ModeloRig> getModelosRigs() {
		return ModelosRigs;
	}
	
	public List<ModeloTanque> getModelosDeTanques() {
		return ModelosDeTanques;
	}
	
	public List<ModeloPlanta> getModeloPlantas() {
		return ModelosPlantas;
	}
	
	public void agregarModeloDeRig(ModeloRig nuevo) {
		ModelosRigs.add(nuevo);
	}
	
	public void agregarModeloDeTanque(ModeloTanque nuevo) {
		ModelosDeTanques.add(nuevo);
	}
	
	public void agregarModeloDePlanta(ModeloPlanta nuevo) {
		ModelosPlantas.add(nuevo);
	}
	
}
