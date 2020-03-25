package com.example.myapplication.model.repository

import android.util.Log
import com.example.myapplication.model.api.RetrofitClient
import com.example.myapplication.model.dto.*
import com.example.myapplication.ultis.common.SharedPrefUtils
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

class UserRepositoryImp : UserRepository {

    companion object {
        private var apiService = RetrofitClient().getInstance().getAPIService()
    }

    private var headers = HashMap<String, String>()

    override fun signIn(signInRequest: SignInRequest): Single<User> {
        return Single.create { emitter ->
            apiService.signIn(signInRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { t: SignInResponse ->
                    setHeaders(t.token)
                    SharedPrefUtils.putSignInResponse(t)
                    getUserDetail()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                }
                .subscribe({ t: User ->
                    Log.d("asd", "user: $t")
                    SharedPrefUtils.putCurrentUserDetail(t)
                    emitter.onSuccess(t)
                }, { t: Throwable ->
                    emitter.onError(t)
                })
        }
    }

    private fun setCurrentUser(
        authoritiesListResponse: List<GetAuthoritiesResponse>,
        displayNameResponse: GetDisplayNameResponse,
        avatarIdResponse: GetUserAvatarIdResponse
    ): User {
        return User(
            authorities = authoritiesListResponse as ArrayList<GetAuthoritiesResponse>,
            displayName = displayNameResponse.displayName,
            avatarUrl = "http://103.74.116.95:8090/auctions-upload-file/api/public/upload/Picture/image?id=${avatarIdResponse.idUpload}"
        )
    }

    private fun getUserDetail(): Single<User> {
        val getAuthorities: Single<List<GetAuthoritiesResponse>> =
            apiService.getAuthorities(headers)
        val getDisplayName: Single<GetDisplayNameResponse> = apiService.getDisplayName(headers)
        val getUserAvatar: Single<GetUserAvatarIdResponse> = apiService.getAvatarId(headers)
        return Single.zip(
            getAuthorities,
            getDisplayName,
            getUserAvatar,
            Function3<List<GetAuthoritiesResponse>, GetDisplayNameResponse, GetUserAvatarIdResponse, User>
            { authoritiesList: List<GetAuthoritiesResponse>,
              displayName: GetDisplayNameResponse,
              avatarId: GetUserAvatarIdResponse ->
                setCurrentUser(authoritiesList, displayName, avatarId)
            }
        )
    }

    private fun setHeaders(token: String) {
        headers["Accept"] = "*/*"
        headers["Authorization"] = "Bearer $token"
    }
}
