/*
 * Copyright 2017 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.scio.examples.extra

import com.spotify.scio.nio.TextIO
import com.spotify.scio.testing.PipelineSpec

class SafeFlatMapExampleTest extends PipelineSpec {

  "SafeFlatMapExample" should "work" in {
    JobTest[SafeFlatMapExample.type]
      .args("--input=in", "--num-sum=num-sum")
      .inputNio(TextIO("in"), Seq("1 foo 3 bar bar"))
      .outputNio(TextIO("num-sum"))(_ should containSingleValue("13"))
      .run()
  }
}
