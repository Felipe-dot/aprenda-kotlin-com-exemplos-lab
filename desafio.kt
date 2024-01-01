enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(
	var nome: String,
    var email: String
)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val stack: List<String>)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel:Nivel, val totalDeCursos: Int, val duracao: Int) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} adicionado a formação")
    }
    
    fun cancelarMatricular(usuario: Usuario) {
        inscritos.removeIf{it == usuario}
        println("Usuário removido: ${usuario.nome}")
    }
    
    fun mostrarAlunosMatriculados() {
        println("Alunos matriculados no curso")
        inscritos.forEach{ usuario -> println(usuario.nome)}
    }
}

fun main() {
    val usuario1 = Usuario("Lucas", "lucas@gmail.com")
    val usuario2 = Usuario("Laura", "lauradev@gmail.com")
    
    val conteudosEducacionais: List<ConteudoEducacional> = listOf(
    	ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 1, listOf("kotlin")),
    	ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 2,  listOf("kotlin")),
    	ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin",2, listOf("kotlin")),
    	ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin",2,  listOf("kotlin"))
    )
    
    val duracaoTotal = conteudosEducacionais.sumBy { it.duracao }
    
    val formacao = Formacao("Desenvolvimento Backend com Kotlin",conteudosEducacionais, Nivel.BASICO, conteudosEducacionais.size,duracaoTotal)
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    formacao.mostrarAlunosMatriculados()
    
    formacao.cancelarMatricular(usuario2)
    
    formacao.mostrarAlunosMatriculados()
    
}
