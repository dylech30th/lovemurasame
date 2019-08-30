package com.github.assistant.model.event

import com.github.assistant.enum.TypeCode

class Enabled(@Transient override val typeCode: TypeCode = TypeCode.Enabled) : ICqApiEvent