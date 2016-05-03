package indyscala.modes

import rapture.json._, jsonBackends.circe._
import scala.concurrent.Future
import scala.util.{Try, Success, Failure}
import scalaz.{\/, \/-, -\/}
import cats.data.Xor

object Explicitly {
  def parseUnsafely(s: String): Json =
    tryParse(s) match {
      case Success(json) => json
      case Failure(e) => throw e
    }

  def tryParse(s: String): Try[Json] =
    Try(Json.parse(s))

  def parseEither(s: String): Either[String, Json] =
    tryParse(s) match {
      case Success(json) => Right(json)
      case Failure(e) => Left(e.getMessage)
    }

  def parseOption(s: String): Option[Json] =
    tryParse(s).toOption

  def parseFuture(s: String): Future[Json] =
    tryParse(s) match {
      case Success(json) => Future.successful(json)
      case Failure(e) => Future.failed(e)
    }

  def parseLikeIts1999(s: String): Json =
    parseOption(s).getOrElse(null)

  def parseScalaz(s: String): \/[String, Json] =
    tryParse(s) match {
      case Success(json) => \/-(json)
      case Failure(e) => -\/(e.getMessage)
    }

  def parseCats(s: String): Throwable Xor Json =
    tryParse(s) match {
      case Success(json) => Xor.Right(json)
      case Failure(e) => Xor.Left(e)
    }
}
