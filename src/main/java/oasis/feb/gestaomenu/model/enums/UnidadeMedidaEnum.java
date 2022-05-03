package oasis.feb.gestaomenu.model.enums;

public enum UnidadeMedidaEnum {
	QUILOGRAMA("kg"), GRAMA("g"), LITRO("l"), DECILITRO("dl"), CENTILITRO("cl"), MILILITRO("ml"), UNIDADE("un");

    private String unidade;

    private UnidadeMedidaEnum(String unidade) {
        this.unidade = unidade;
    }

    public String getUnidade() {
        return unidade;
    }

}
