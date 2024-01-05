const del = document.getElementById("del");
const mod = document.getElementById("mod");
const frm = document.getElementById("frm");

mod.addEventListener("click", function () {
    const region_id = mod.getAttribute("data-region-id");
    location.href = "../update?region_id=" + region_id;
});

del.addEventListener("click", function () {
    frm.submit();
});
