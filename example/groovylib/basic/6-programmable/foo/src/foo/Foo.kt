package foo

import groovy.cli.commons.CliBuilder
import groovy.xml.MarkupBuilder
class Foo : CliktCommand() {
    val text by option("-t", "--text", help = "text to insert").required()
    override fun run() {
        echo(generateHtml(text))
    }
}

fun generateHtml(text: String): String = createHTML(prettyPrint = false).h1 { text(text) }.toString()

fun main(args: Array<String>) = Foo().main(args)
