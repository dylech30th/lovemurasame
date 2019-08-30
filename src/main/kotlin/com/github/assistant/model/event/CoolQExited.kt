package com.github.assistant.model.event

import com.github.assistant.enum.TypeCode

class CoolQExited(@Transient override val typeCode: TypeCode = TypeCode.CoolQExited) : ICqApiEvent