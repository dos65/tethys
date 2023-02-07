package tethys.derivation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers.shouldBe
import tethys.commons.TokenNode
import tethys.commons.TokenNode.obj
import tethys.derivation.builder.{FieldStyle, WriterBuilder, WriterDerivationConfig}
import tethys.derivation.semiauto.*
import tethys.writers.instances.SimpleJsonObjectWriter
import tethys.writers.tokens.SimpleTokenWriter.*
import tethys.{JsonObjectWriter, JsonWriter}

class Scala3LazyValTest extends AnyFlatSpec with Matchers {

  /*
  def_in_macro=[lazy val] & use=[lazy val] => ???

  def_in_macro=[lazy val] & use=[val] => ???

  def_in_macro=[val] & use=[lazy val] => WORKAROUND
  [info]       ---
  [info]       {
  [info]         implicit lazy val cc3Writer: tethys.JsonWriter[tethys.derivation.CC3] = ({
  [info]           final class $anon() extends tethys.JsonObjectWriter[tethys.derivation.CC3] {
  [info]             implicit def thisWriter: tethys.JsonWriter[tethys.derivation.CC3] = scala.Some.apply[tethys.JsonWriter[tethys.derivation.CC3]](cc3Writer).getOrElse[tethys.JsonWriter[tethys.derivation.CC3]](this)
  [info]             override def writeValues(value: tethys.derivation.CC3, tokenWriter: tethys.writers.tokens.TokenWriter): scala.Unit = {
  [info]               tethys.JsonWriter.intWriter.write("i", value.i, tokenWriter)
  [info]               tethys.JsonWriter.optionalWriter[tethys.derivation.CC3]($anon.this.thisWriter).write("o", value.o, tokenWriter)
  [info]               ()
  [info]             }
  [info]           }
  [info]
  [info]           (new $anon(): tethys.JsonObjectWriter[tethys.derivation.CC3])
  [info]         }: tethys.JsonObjectWriter[tethys.derivation.CC3])
  [info]         ()
  [info]       }
  [info]       ---

  def_in_macro=[val] & use=[val] => ERROR
  [info]       ---
  [info]       {
  [info]         implicit val cc3Writer: tethys.JsonWriter[tethys.derivation.CC3] = ({
  [info]           final class $anon() extends tethys.JsonObjectWriter[tethys.derivation.CC3] {
  [info]             implicit def thisWriter: tethys.JsonWriter[tethys.derivation.CC3] = scala.Some.apply[tethys.JsonWriter[tethys.derivation.CC3]](cc3Writer).getOrElse[tethys.JsonWriter[tethys.derivation.CC3]](this)
  [info]             override def writeValues(value: tethys.derivation.CC3, tokenWriter: tethys.writers.tokens.TokenWriter): scala.Unit = {
  [info]               tethys.JsonWriter.intWriter.write("i", value.i, tokenWriter)
  [info]               tethys.JsonWriter.optionalWriter[tethys.derivation.CC3]($anon.this.thisWriter).write("o", value.o, tokenWriter)
  [info]               ()
  [info]             }
  [info]           }
  [info]
  [info]           (new $anon(): tethys.JsonObjectWriter[tethys.derivation.CC3])
  [info]         }: tethys.JsonObjectWriter[tethys.derivation.CC3])
  [info]         ()
  [info]       }
  [info]       ---
  */

  it should "work without lazy vals" in {
//    macrolizer.show("ansi") {
      implicit val cc3Writer: JsonWriter[CC3] = jsonWriter
//    }
  }
}

sealed trait ST3

case class CC3(i: Int, ob: Option[CC3]) extends ST3