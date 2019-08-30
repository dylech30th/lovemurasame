package com.github.assistant.enum

enum class TypeCode {
    CoolQExited,
    Disabled,
    Enabled,
    Initialize,
    ProcessAddFriendEventOutput,
    ProcessDiscussGroupMessage,
    ProcessFriendsAdded,
    ProcessGroupAdminChange,
    ProcessGroupMemberDecrease,
    ProcessGroupMemberIncrease,
    ProcessGroupMessage,
    ProcessGroupUpload,
    ProcessJoinGroupEventOutput,
    ProcessPrivateMessage;

    companion object {
        fun parse(string: String): TypeCode? {
            return values().firstOrNull { it.name == string }
        }
    }
}