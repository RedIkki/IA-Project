import java.util.LinkedList;

public class frutasFavoritas {
    private String name;
    private LinkedList<Fruta> frutas;

    // Classe interna para representar uma fruta com preferência
    public static class Fruta {
        private String nome;
        private int preferencia;

        public Fruta(String nome, int preferencia) {
            this.nome = nome;
            this.preferencia = preferencia;
        }

        public String getNome() {
            return nome;
        }

        public int getPreferencia() {
            return preferencia;
        }

        public void incrementarPreferencia() {
            this.preferencia++;
        }

        @Override
        public String toString() {
            return nome + " (Preferência: " + preferencia + ")";
        }
    }

    public frutasFavoritas(String name) {
        this.name = name;
        this.frutas = new LinkedList<>();
    }

    // Método para adicionar frutas à lista com preferência
    public void adicionarFruta(String fruta, int preferencia) {
        this.frutas.add(new Fruta(fruta, preferencia));
    }

    // Método para adicionar frutas à lista com preferência padrão 0
    public void adicionarFruta(String fruta) {
        adicionarFruta(fruta, 0);
    }

    // Método para incrementar a preferência de uma fruta específica
    public void incrementarPreferencia(String frutaNome) {
        for (Fruta f : frutas) {
            if (f.getNome().equals(frutaNome)) {
                f.incrementarPreferencia();
                return;
            }
        }
        System.out.println("Fruta não encontrada: " + frutaNome);
    }

    // Método para obter a lista de frutas
    public LinkedList<Fruta> getFrutas() {
        return this.frutas;
    }

    // Método para obter o nome
    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        frutasFavoritas minhaLista = new frutasFavoritas("Minhas Frutas Favoritas");
        minhaLista.adicionarFruta("Maçã", 1);
        minhaLista.adicionarFruta("Banana"); // usando preferência padrão 0
        System.out.println("Nome: " + minhaLista.getName());
        System.out.println("Frutas antes: " + minhaLista.getFrutas());
        minhaLista.incrementarPreferencia("Maçã");
        System.out.println("Frutas depois: " + minhaLista.getFrutas());
    }
}