$ ->
  $.get "/user_list", (data) ->
    $.each data, (index, item) ->
      $("#users").append $("<li>").text item.name


  $.get "/user_view?name=db", (data) ->
    $.each data, (index, item) ->
      $("#user_view").append $("<li>").text item.name


