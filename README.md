- **1º) Comentário:**  

Programação e engenharia de software envolvem três aspectos fundamentais: tempo, escala e escolhas estratégicas. Na engenharia de software, há uma preocupação maior com o tempo e a necessidade de mudanças futuras, além da eficiência e escalabilidade do software e da organização que o desenvolve. Engenheiros de software precisam planejar para o crescimento contínuo, tanto do sistema quanto da equipe de desenvolvimento, adotando práticas como modularidade, automação de processos e documentação robusta para facilitar adaptações e manutenções ao longo do tempo.  

Além disso, a engenharia de software requer um olhar estratégico para as decisões, que geralmente envolvem escolhas de alto risco e impacto, fundamentadas em estimativas imprecisas de tempo e crescimento. Conforme destacado no livro *Engenharia de Software no Google*, práticas como *code reviews*, gerenciamento de dívida técnica e uso de métricas ajudam a mitigar esses riscos. A escalabilidade é outro aspecto crítico, pois soluções precisam ser projetadas para crescer sem comprometer o desempenho ou a eficiência operacional, uma questão amplamente discutida na International Conference on Software Engineering (ICSE).  

Por fim, enquanto a programação pode ser vista como a implementação de soluções imediatas, a engenharia de software se foca em processos e metodologias que garantem a qualidade, sustentabilidade e evolução do software em longo prazo, como explorado no artigo *Programação vs. Engenharia de Software: Qual a Diferença?*. Isso inclui integrar ferramentas e práticas que permitem gerenciar a complexidade do sistema e de suas dependências em um ambiente corporativo ou de larga escala.

**Referências:**

Livro: **"Software Engineering at Google"**
Este livro explora práticas modernas de engenharia de software, incluindo gestão de mudanças, escalabilidade e tomada de decisões complexas em organizações de grande porte.

Artigo: **"Programming vs. Software Engineering: What's the Difference?"** - Medium
Disponível online, este artigo explica as diferenças entre as práticas de programação e os princípios da engenharia de software, destacando o impacto do tempo e da escala.

Conferência: **International Conference on Software Engineering (ICSE)**
Este evento reúne especialistas para discutir tendências e desafios da engenharia de software, incluindo tópicos relacionados à escalabilidade e à gestão de trade-offs.


- **2º) 3 exemplos de trade-off:**

**I)** Um exemplo clássico de tradeoff em programação é o equilíbrio entre desempenho e manutenibilidade. Imagine um sistema que precisa processar rapidamente grandes volumes de dados em tempo real. Nesse caso, optar por algoritmos altamente otimizados pode oferecer uma execução muito mais veloz, mas essa escolha geralmente resulta em um código mais complexo, menos flexível e difícil de modificar ou entender futuramente. Por outro lado, uma abordagem mais manutenível, como o uso de frameworks funcionais como Spark, pode ser mais lenta, mas favorece a clareza e a adaptabilidade do código. Esse dilema ilustra a necessidade de priorizar o que é mais crítico para o sistema: desempenho imediato ou facilidade de manutenção a longo prazo.

**II)** Outro exemplo está no compromisso entre consistência de dados e disponibilidade em sistemas distribuídos. No modelo CAP, é impossível otimizar simultaneamente consistência, disponibilidade e particionamento tolerante. Em situações onde os dados precisam ser sempre precisos e atualizados, como em transações bancárias, a consistência forte é preferida, mas isso pode comprometer a disponibilidade em caso de falhas na rede. Por outro lado, sistemas que priorizam alta disponibilidade, como o Cassandra, mantêm-se funcionais mesmo em condições adversas, mas podem apresentar inconsistências temporárias. Bancos de dados como o PostgreSQL, ao optar por consistência forte, oferecem segurança nos dados, mas em detrimento da resiliência total.

**III)** Por fim, a relação entre segurança e usabilidade é outro tradeoff comum. Sistemas que demandam alta segurança, como autenticação multifator, protegem os dados de forma eficaz, mas podem criar barreiras para os usuários, dificultando o acesso ou tornando o fluxo menos intuitivo. Em contraste, permitir logins automáticos pode oferecer uma experiência mais fluida, mas expõe o sistema a riscos de segurança. Por exemplo, o uso de tokens temporários aumenta a proteção, mas pode ser visto como inconveniente, enquanto a ausência dessa medida facilita o uso, porém reduz a proteção contra acessos não autorizados. Essas decisões precisam ser cuidadosamente ponderadas para atender aos objetivos do sistema e às expectativas dos usuários.

- **3º) 3 - projeto java com junit testes**

```declarative
// import das classes utilitárias
import java.util.List;
import java.util.LinkedList;

// definição da classe da biblioteca
public class Biblioteca {
    // atributo da classe
    private List<Livro> livros = new LinkedList<Livro>();

    // métodos para acessar o atributo da classe por fora da classe
    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public List<Livro> getLivros() {
        return this.livros;
    }
}
```
```declarative
// definição da classe do livro
public class Livro {
    // atributos da classe
    private String titulo;
    private String isbn;

    // construtor da classe
    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    // métodos para acessar o atributo da classe por fora da classe
    public String getTitulo() {
        return this.titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }
}
```

```declarative
// import das classes utilitárias
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

// definição da classe teste
class BibliotecaTeste {
    // decorator do teste
    @Test
    void testAdicionarDoisLivros() {
        // instancia uma biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // instancia livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "1234567890");
        Livro livro2 = new Livro("O Hobbit", "0987654321");

        // adiciona os livros na biblioteca
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        // verifica se a biblioteca tem os dois livros cadastrados
        assertEquals(biblioteca.getLivros().size(), 2);
    }

    @Test
    void testTrazPrimeiroLivroDaLista() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("1984", "123");
        Livro livro2 = new Livro("Admirável Mundo Novo", "321");
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        // associa todos os livros da biblioteca em uma variável
        List<Livro> todosLivros = biblioteca.getLivros();

        // verifica se o primeiro livro é o primeiro livro cadastrado
        assertEquals(todosLivros.get(0).getIsbn(), livro1.getIsbn());
    }

    @Test
    void testLivrosSaoDiferentes() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("A Revolução dos Bichos", "456");
        Livro livro2 = new Livro("Fahrenheit 451", "654");
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        List<Livro> todosLivros = biblioteca.getLivros();
        // verifica se os dois livros são diferentes
        assertNotEquals(todosLivros.get(0).getTitulo(), todosLivros.get(1).getTitulo());
    }
}
```

- **4º) Diagrama de classes UML**

| Class        | Attributes        | Methods                 |
|--------------|-------------------|-------------------------|
| Biblioteca   | - List<Livro> livros | - adicionarLivro(Livro) |
|              |                   | - getLivros() : List<Livro> |
| Livro        | - String titulo    | - getTitulo() : String  |
|              | - String isbn     | - getIsbn() : String    |

Biblioteca contains * Livro

