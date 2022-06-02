data class Post(
    val id: Int,
    private val date: Int = (System.currentTimeMillis() / 1000).toInt(),
    val ownerId: Int = 5,
    val fromId: Int = 5,
    val createdBy: Int? = null,
    val text: String,
    val replyOwnerId: Int? = null,
    val replyPostId: Int = 5,
    val friendOnly: Boolean = true,
    val postType: Int = 5,
    val singerId: Int = 5,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val comments: Comments = Comments(5, true, true),
    val likes: Like = Like(count = 0, userLikes = true, canLike = false, canPublish = true),
    val reports: Repost = Repost(5, true),
    val attachment: List<Attachment> = emptyList(),
    val sealedAttachment: List<SealedAttachment> = emptyList()
) {

    data class Comments(
        val count: Int,
        val canPost: Boolean,
        val groupCanPost: Boolean,
    )

    data class Like(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean,
    )

    class Repost(
        val count: Int,
        val userReposted: Boolean,
    )


    class Document(
        val idDocument: Int = 5,
        val ownerIdDocument: Int = 5,
        val titleDocument: Int = 5,
        val sizeDocument: Int = 5,
        val extDocument: String = "",
        val urlDocument: String = "",
        val dateDocument: Int = 5,
        val typeDocument: Int = 5,
    )

    class Link(
        val urlLink: String = "",
        val titleLink: String = "",
        val captionLink: String = "",
        val descriptionLink: String = "",
        val previewPageLink: String = "",
        val previewUrlLink: String = ""

    )

    class Note(
        val idNote: Int = 5,
        val ownerIdNote: Int = 5,
        val titleNot: String = "",
        val textNote: String = "",
        val dateNote: Int = 5,
        val commentsNote: Int = 5,
        val readCommentsNote: Int = 5,
        val viewUrlNote: String = ""
    )

    class Page(
        val idPage: Int = 5,
        val groupIdPage: Int = 5,
        val creatorIdPage: Int = 5,
        val titlePage: String = "",
        val currentUserCanEditPage: Boolean = true
    )


    class Poll(
        val idPoll: Int = 5,
        val ownerIdPoll: Int = 5,
        val createdPoll: Int = 5,
        val questionPoll: String = "",
        val votesPoll: Int = 5
    )

    class PostSource(
        val typePostSource: String = "",
        val platformPostSource: String = "",
        val dataPostSource: String = "",
        val urlPostSource: String = ""
    )

    class Sticker(
        val productIdSticker: Int = 5,
        val stickerIdSticker: Int = 5
    )


    abstract class Attachment(
        val type: String
    )

    class VideoAttachment(type: String, val video: Video) : Attachment(type) {

    }

    data class Video(
        val idVideo: Int = 5,
        val ownerIdVideo: Int = 5,
        val titleVideo: String = "",
        val descriptionVideo: String = "",
        val durationVideo: Int = 5
    )


    class AudioAttachment(type: String, val audio: Audio) : Attachment(type) {
    }

    data class Audio(
        val idAudio: Int = 5,
        val ownerIdAudio: Int = 5,
        val artistAudio: String = "",
        val titleAudio: String = "",
        val duration: Int = 5,

        )


    class PhotoAttachment(type: String, val photo: Photo) : Attachment(type) {

    }

    data class Photo(
        val idPhoto: Int = 5,
        val albumIdPhoto: Int = 5,
        val ownerIdPhoto: Int = 5,
        val userIdPhoto: Int = 5,
        val textPhoto: String = ""
    )


    sealed class SealedAttachment (val type: String) {

        class AttachmentAudio(val audio: Audio) : SealedAttachment("audio")
        class AttachmentVideo(val video: Video) : SealedAttachment("video")
        class AttachmentPhoto(val photo: Photo) : SealedAttachment("photo")

    }

}
