<!DOCTYPE nsscheme>
<nsscheme type="sequence">
  <position>
    <x>4</x>
    <y>30</y>
  </position>
  <size>
    <width>1812</width>
    <height>814</height>
  </size>
  <name>zad.2</name>
  <comment></comment>
  <author>zad.2</author>
  <pascalCode contains="yes"/>
  <checkSyntax enabled="yes"/>
  <variables>
    <variable>
      <name>a</name>
      <type>
        <double/>
      </type>
      <value>1.60221e-306</value>
    </variable>
    <variable>
      <name>b</name>
      <type>
        <double/>
      </type>
      <value>7.56604e-307</value>
    </variable>
    <variable>
      <name>c</name>
      <type>
        <double/>
      </type>
      <value>8.9007e-308</value>
    </variable>
  </variables>
  <sequence>
    <inputinstruction>
      <text>a</text>
      <comment></comment>
    </inputinstruction>
    <inputinstruction>
      <text>b</text>
      <comment></comment>
    </inputinstruction>
    <inputinstruction>
      <text>c</text>
      <comment></comment>
    </inputinstruction>
    <selection instructionsheight="588" conditionheight="106">
      <condition>
        <text>(a+b)>c</text>
        <comment></comment>
      </condition>
      <ontrue>
        <sequence>
          <selection instructionsheight="493" conditionheight="89">
            <condition>
              <text>(a+c)>b</text>
              <comment></comment>
            </condition>
            <ontrue>
              <sequence>
                <selection instructionsheight="413" conditionheight="74">
                  <condition>
                    <text>(b+c)>a</text>
                    <comment></comment>
                  </condition>
                  <ontrue>
                    <sequence>
                      <outputinstruction>
                        <text>'Pole to: ', (a+b+c)/2</text>
                        <comment></comment>
                      </outputinstruction>
                      <selection instructionsheight="326" conditionheight="59">
                        <condition>
                          <text>((a*a)+(b*b))=(c*c)</text>
                          <comment></comment>
                        </condition>
                        <ontrue>
                          <sequence>
                            <outputinstruction>
                              <text>'trojkat jest prostokatny'</text>
                              <comment></comment>
                            </outputinstruction>
                          </sequence>
                        </ontrue>
                        <onfalse>
                          <sequence>
                            <selection instructionsheight="271" conditionheight="49">
                              <condition>
                                <text>((a*a)+(b*b))>(c*c)</text>
                                <comment></comment>
                              </condition>
                              <ontrue>
                                <sequence>
                                  <outputinstruction>
                                    <text>'trojkat jest ostrokatny'</text>
                                    <comment></comment>
                                  </outputinstruction>
                                </sequence>
                              </ontrue>
                              <onfalse>
                                <sequence>
                                  <outputinstruction>
                                    <text>'trojkat jest rozwartokatny'</text>
                                    <comment></comment>
                                  </outputinstruction>
                                </sequence>
                              </onfalse>
                            </selection>
                          </sequence>
                        </onfalse>
                      </selection>
                    </sequence>
                  </ontrue>
                  <onfalse>
                    <sequence>
                      <outputinstruction>
                        <text>'Nie da sie stworzyc tego trojkata'</text>
                        <comment></comment>
                      </outputinstruction>
                    </sequence>
                  </onfalse>
                </selection>
              </sequence>
            </ontrue>
            <onfalse>
              <sequence>
                <outputinstruction>
                  <text>'Nie da sie stworzyc tego trojkata'</text>
                  <comment></comment>
                </outputinstruction>
              </sequence>
            </onfalse>
          </selection>
        </sequence>
      </ontrue>
      <onfalse>
        <sequence>
          <outputinstruction>
            <text>'Nie da sie stworzyc tego trojkata'</text>
            <comment></comment>
          </outputinstruction>
        </sequence>
      </onfalse>
    </selection>
  </sequence>
</nsscheme>
