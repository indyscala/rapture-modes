package indyscala.modes

import rapture.core.Mode
import rapture.json._, jsonBackends.circe._

object Modally {
  def parse(s: String)(implicit mode: Mode[_]): mode.Wrap[Json, Exception] =
    mode.wrap(Explicitly.parseUnsafely(s))
}
