package tethys.derivation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import tethys.JsonWriter
import tethys.derivation.semiauto.jsonWriter

class Scala2LazyValTest extends AnyFlatSpec with Matchers {

  /*
  def_in_macro=[lazy val] & use=[lazy val] => TOO LAZY
  [info]          {
  [info]            implicit lazy val cc2Writer: tethys.JsonWriter[CC2] = (((({
  [info]              final class $anon extends tethys.JsonObjectWriter[tethys.derivation.CC2] {
  [info]                lazy private[this] val fresh$macro$6 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Option[tethys.derivation.CC2]]](
  [info]                    tethys.JsonWriter.optionalWriter[tethys.derivation.CC2](cc2Writer)
  [info]                  );
  [info]                lazy private[this] val fresh$macro$5 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Int]](tethys.JsonWriter.intWriter);
  [info]                override def writeValues(
  [info]                    value: tethys.derivation.CC2,
  [info]                    tokenWriter: tethys.writers.tokens.TokenWriter
  [info]                ): scala.Unit = {
  [info]                  $anon.this.fresh$macro$5.write("i", value.i, tokenWriter);
  [info]                  $anon.this.fresh$macro$6.write("o", value.o, tokenWriter)
  [info]                }
  [info]              };
  [info]              new $anon()
  [info]            }): tethys.JsonObjectWriter[
  [info]              tethys.derivation.CC2
  [info]            ])): tethys.JsonObjectWriter[tethys.derivation.CC2]);
  [info]            ()
  [info]          }

  def_in_macro=[lazy val] & use=[val] => BEST
  [info]          {
  [info]            implicit val cc2Writer: tethys.JsonWriter[CC2] = (((({
  [info]              final class $anon extends tethys.JsonObjectWriter[tethys.derivation.CC2] {
  [info]                lazy private[this] val fresh$macro$6 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Option[tethys.derivation.CC2]]](
  [info]                    tethys.JsonWriter.optionalWriter[tethys.derivation.CC2](cc2Writer)
  [info]                  );
  [info]                lazy private[this] val fresh$macro$5 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Int]](tethys.JsonWriter.intWriter);
  [info]                override def writeValues(
  [info]                    value: tethys.derivation.CC2,
  [info]                    tokenWriter: tethys.writers.tokens.TokenWriter
  [info]                ): scala.Unit = {
  [info]                  $anon.this.fresh$macro$5.write("i", value.i, tokenWriter);
  [info]                  $anon.this.fresh$macro$6.write("o", value.o, tokenWriter)
  [info]                }
  [info]              };
  [info]              new $anon()
  [info]            }): tethys.JsonObjectWriter[
  [info]              tethys.derivation.CC2
  [info]            ])): tethys.JsonObjectWriter[tethys.derivation.CC2]);
  [info]            ()
  [info]          }

  def_in_macro=[val] & use=[lazy val] => WORKAROUND
  [info]          {
  [info]            implicit lazy val cc2Writer: tethys.JsonWriter[CC2] = (((({
  [info]              final class $anon extends tethys.JsonObjectWriter[tethys.derivation.CC2] {
  [info]                private[this] val fresh$macro$6 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Option[tethys.derivation.CC2]]](
  [info]                    tethys.JsonWriter.optionalWriter[tethys.derivation.CC2](cc2Writer)
  [info]                  );
  [info]                private[this] val fresh$macro$5 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Int]](tethys.JsonWriter.intWriter);
  [info]                override def writeValues(
  [info]                    value: tethys.derivation.CC2,
  [info]                    tokenWriter: tethys.writers.tokens.TokenWriter
  [info]                ): scala.Unit = {
  [info]                  $anon.this.fresh$macro$5.write("i", value.i, tokenWriter);
  [info]                  $anon.this.fresh$macro$6.write("o", value.o, tokenWriter)
  [info]                }
  [info]              };
  [info]              new $anon()
  [info]            }): tethys.JsonObjectWriter[
  [info]              tethys.derivation.CC2
  [info]            ])): tethys.JsonObjectWriter[tethys.derivation.CC2]);
  [info]            ()
  [info]          }

  def_in_macro=[val] & use=[val] => ERROR
  [info]          {
  [info]            implicit val cc2Writer: tethys.JsonWriter[CC2] = (((({
  [info]              final class $anon extends tethys.JsonObjectWriter[tethys.derivation.CC2] {
  [info]                private[this] val fresh$macro$6 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Option[tethys.derivation.CC2]]](
  [info]                    tethys.JsonWriter.optionalWriter[tethys.derivation.CC2](cc2Writer)
  [info]                  );
  [info]                private[this] val fresh$macro$5 = scala.Predef
  [info]                  .implicitly[tethys.JsonWriter[Int]](tethys.JsonWriter.intWriter);
  [info]                override def writeValues(
  [info]                    value: tethys.derivation.CC2,
  [info]                    tokenWriter: tethys.writers.tokens.TokenWriter
  [info]                ): scala.Unit = {
  [info]                  $anon.this.fresh$macro$5.write("i", value.i, tokenWriter);
  [info]                  $anon.this.fresh$macro$6.write("o", value.o, tokenWriter)
  [info]                }
  [info]              };
  [info]              new $anon()
  [info]            }): tethys.JsonObjectWriter[
  [info]              tethys.derivation.CC2
  [info]            ])): tethys.JsonObjectWriter[tethys.derivation.CC2]);
  [info]            ()
  [info]          }
  */

  it should "work without lazy vals" in {
//    macrolizer.show {
      implicit val cc2Writer: JsonWriter[CC2] = jsonWriter
//    }
  }
}

sealed trait ST2

case class CC2(i: Int, ob: Option[CC2]) extends ST2
