document.getElementById("crxBtn").addEventListener("click", function () {
            window.open("http://localhost:4502/crx/de/index.jsp", '_blank');
    },
    false);

document.getElementById("adminBtn").addEventListener("click", function () {
                window.open("http://localhost:4502/aem/start.html", '_blank');
    },
    false);

    document.getElementById("damBtn").addEventListener("click", function () {
                    window.open("http://localhost:4502/assets.html/content/dam", '_blank');
        },
        false);


document.getElementById("searchFiledResponse").addEventListener("keyup", function () {

                        var input = document.getElementById("searchFiledResponse");
                        var filter = input.value.toLowerCase();
                        var nodes = document.getElementsByClassName('response-editors');

                        for (i = 0; i < nodes.length; i++) {

                          if (nodes[i].innerText.toLowerCase().includes(filter)) {
                            nodes[i].style.color = "red";
                          } else {
                            nodes[i].style.color = "black";
                          }
                        }


    },
    false);
