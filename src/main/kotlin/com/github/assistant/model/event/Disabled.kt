package com.github.assistant.model.event

import com.github.assistant.enum.TypeCode

class Disabled(@Transient override val typeCode: TypeCode = TypeCode.Disabled) : ICqApiEvent