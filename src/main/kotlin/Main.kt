fun main() {


}

object WallService {
    private var posts = emptyArray<Post>()
    private var maxId: Int = 0

    fun getNewId(): Int {
        maxId += 1
        return maxId
    }

    fun add(post: Post): Post {

        // добавляем пост в массив
        posts += post

        return posts.last()
    }

    fun update(updatedPost: Post): Boolean {

        for ((index, post) in posts.withIndex()) {
            if (post.id == updatedPost.id) {
                posts[index] = updatedPost
                return true
            }
        }
        return false

    }

    fun getById(id: Int): Post? {

        for (post in posts) {
            if (post.id == id) {
                return post
            }
        }
        return null
    }

}
