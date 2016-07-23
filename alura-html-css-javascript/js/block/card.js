var $cards = document.querySelectorAll('.card');

for (var index = 0; index < $cards.length; index++) {
  $cards[index].addEventListener('click', function (event) {
    var $this = event.target;
    var $card = this;
    var $cardColors = $card.querySelectorAll('.card-options');

    if ($this.classList.contains('card-options')) {
      $card.dataset.color = $this.dataset.color;

      for (var position = 0; position < $cardColors.length; position++) {
        $cardColors[position].classList.remove('isActive');
      };

      $this.classList.add('isActive');
    };
  });
};
