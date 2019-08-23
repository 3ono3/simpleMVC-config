/**
			var formData = new FormData();
            var files[0]=$('#file-input-id')[0].files;
			formData.append('file', files[0]);
			formData.append('representationId', reportView.getModel().representationId);
			formData.append('fileName' ,files[0].name);
			//
			ajaxUploadFile({
				formData : formData,
				url : urlPrefix + '/admin/attachment/upload_signle.service',
				progress : function(value, totle, fileName) {
				//..
				},
				load : function(e, fileName) {
				//..
				},
				error : function(e, fileName) {
				//..
				},
				onreadystatechange : function(e, fileName) {
				//..
				}
			});
 */
function ajaxUploadFile(options) {

    // 制作表单
    var xhr = new XMLHttpRequest();
    // 上传进度
    xhr.upload.addEventListener('progress', function (event) {
        if (options.progress) {
            options.progress(event.loaded, event.total, options.fileName);
        }
    }, false);

    // 上传完成
    xhr.upload.addEventListener('load', function (event) {
        if (options.load) {
            options.load(event, options.fileName);
        }
    }, false);

    // 上传失败
    xhr.upload.addEventListener('error', function (event) {
        if (options.error) {
            options.error(event, options.fileName);
        }
    }, false);
    // 状态改变
    xhr.onreadystatechange = function (event) {
        if (options.onreadystatechange) {
            options.onreadystatechange(event, options.fileName);
        }

    };
    xhr.open('POST', options.url);
    xhr.send(options.formData);
}