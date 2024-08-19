const commentPerPage = 20;
const comments = replieslist;
const totalComments = comments.length;
let currentPage = 1;

window.addEventListener('load', init);