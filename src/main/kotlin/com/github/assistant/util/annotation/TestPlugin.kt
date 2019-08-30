package com.github.assistant.util.annotation

/* used to describe a plugin is used for test */
annotation class TestPlugin
/* used to describe a plugin is deprecated */
annotation class DeprecatedPlugin
/* used to describe a plugin is currently idle */
annotation class IdlePlugin(val until: String = "", val format: String = "")