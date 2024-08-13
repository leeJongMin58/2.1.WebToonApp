package com.jomiroid.webtoonapp

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebToonWebViewClient(
    private val progressBar: ProgressBar,
    private val saveData : (String) -> Unit
): WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //
        if (request != null && request.url.toString().contains("https://comic.naver.com/webtoon/")) {
            saveData(request.url.toString())
        }
        // https://comic.naver.com/webtoon/list?titleId=747269&tab=wed
        //


        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        progressBar.visibility = View.VISIBLE
    }
}
